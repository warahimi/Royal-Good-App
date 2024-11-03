import React, { useContext, useEffect, useState } from "react";
import Title from "../components/Title";
import ProductItem from "../components/ProductItem";
import { ShopContext } from "../context/ShopContext";
import { assets } from "../assets/assets";

const Collection = () => {
  // Retrieve products, search term, and search visibility from the ShopContext
  const { products, search, showSearch } = useContext(ShopContext);

  // Define states for filtered products, selected categories, selected subcategories, filter visibility, and sort type
  const [filterProducts, setFilterProducts] = useState([]);
  const [category, setCategory] = useState([]);
  const [subCategory, setSubCategory] = useState([]);
  const [showFilter, setShowFilter] = useState(false);
  const [sortType, setSortType] = useState("relevant");

  // Toggle category selection in the filter
  const toggleCategory = (e) => {
    // If the category is already selected, remove it; otherwise, add it to the list
    if (category.includes(e.target.value)) {
      setCategory((prev) => prev.filter((a) => a !== e.target.value));
    } else {
      setCategory((prev) => [...prev, e.target.value]);
    }
  };

  // Toggle subcategory selection in the filter
  const toggleSubCategory = (e) => {
    // If the subcategory is already selected, remove it; otherwise, add it to the list
    if (subCategory.includes(e.target.value)) {
      setSubCategory((prev) => prev.filter((a) => a !== e.target.value));
    } else {
      setSubCategory((prev) => [...prev, e.target.value]);
    }
  };

  // Apply filters based on search term, category, and subcategory selections
  const applyFilter = () => {
    // Create a copy of the products array to avoid modifying the original array
    let productsCopy = products.slice();

    // Filter by search term if search is visible and has a value
    if (showSearch && search) {
      productsCopy = productsCopy.filter((item) =>
        item.name.toLowerCase().includes(search.toLowerCase())
      );
    }

    // Filter by selected categories if any are selected
    if (category.length > 0) {
      productsCopy = productsCopy.filter((item) =>
        category.includes(item.category)
      );
    }

    // Filter by selected subcategories if any are selected
    if (subCategory.length > 0) {
      productsCopy = productsCopy.filter((item) =>
        subCategory.includes(item.subCategory)
      );
    }

    // Update the filtered products state
    setFilterProducts(productsCopy);
  };

  // Sort the filtered products based on the selected sort type
  const sortProduct = () => {
    // Create a copy of the filtered products array
    let fpCopy = filterProducts.slice();

    // Sort by price in ascending or descending order based on sort type
    switch (sortType) {
      case "low-high":
        setFilterProducts(fpCopy.sort((a, b) => a.price - b.price));
        break;

      case "high-low":
        setFilterProducts(fpCopy.sort((a, b) => b.price - a.price));
        break;

      default:
        applyFilter(); // For 'relevant' sorting, reapply the filter without additional sorting
        break;
    }
  };

  // Reapply filters when category, subcategory, search term, or search visibility changes
  useEffect(() => {
    applyFilter();
  }, [category, subCategory, search, showSearch]);

  // Resort products when the sort type changes
  useEffect(() => {
    sortProduct();
  }, [sortType]);

  return (
    <div className="flex flex-col sm:flex-row gap-1 sm:gap-10 pt-10 border-t">
      {/* Filter Options Section */}
      <div className="min-w-60">
        <p
          onClick={() => setShowFilter(!showFilter)}
          className="my-2 text-xl flex items-center cursor-pointer gap-2"
        >
          FILTERS
          <img
            className={`h-3 sm:hidden ${showFilter ? " rotate-90" : ""}`}
            src={assets.dropdown_icon}
            alt=""
          />
        </p>

        {/* Category Filter */}
        <div
          className={`border border-gray-300 pl-5 py-3 mt-6 ${
            showFilter ? "" : "hidden"
          } sm:block`}
        >
          <p className="mb-3 text-sm font-medium">CATEGORIES</p>
          <div className="flex flex-col gap-2 text-sm font-light text-gray-700">
            {/* Category options for 'Men', 'Women', and 'Kids' */}
            <p className="flex gap-2">
              <input
                className="w-3"
                value={"Men"}
                onChange={toggleCategory}
                type="checkbox"
              />{" "}
              Men{" "}
            </p>
            <p className="flex gap-2">
              <input
                className="w-3"
                value={"Women"}
                onChange={toggleCategory}
                type="checkbox"
              />{" "}
              Women{" "}
            </p>
            <p className="flex gap-2">
              <input
                className="w-3"
                value={"Kids"}
                onChange={toggleCategory}
                type="checkbox"
              />{" "}
              Kids{" "}
            </p>
          </div>
        </div>

        {/* Subcategory Filter */}
        <div
          className={`border border-gray-300 pl-5 py-3 my-5 ${
            showFilter ? "" : "hidden"
          } sm:block`}
        >
          <p className="mb-3 text-sm font-medium">TYPE</p>
          <div className="flex flex-col gap-2 text-sm font-light text-gray-700">
            {/* Subcategory options for 'Topwear', 'Bottomwear', and 'Winterwear' */}
            <p className="flex gap-2">
              <input
                className="w-3"
                value={"Topwear"}
                onChange={toggleSubCategory}
                type="checkbox"
              />{" "}
              Topwear{" "}
            </p>
            <p className="flex gap-2">
              <input
                className="w-3"
                value={"Bottomwear"}
                onChange={toggleSubCategory}
                type="checkbox"
              />{" "}
              Bottomwear{" "}
            </p>
            <p className="flex gap-2">
              <input
                className="w-3"
                value={"Winterwear"}
                onChange={toggleSubCategory}
                type="checkbox"
              />{" "}
              Winterwear{" "}
            </p>
          </div>
        </div>
      </div>

      {/* Product Display Section */}
      <div className="flex-1">
        {/* Header with Title and Sort Option */}
        <div className="flex justify-between text-base sm:text-2xl mb-4">
          <Title text1={"ALL"} text2={"COLLECTIONS"} />

          {/* Product Sort Dropdown */}
          <select
            onChange={(e) => setSortType(e.target.value)}
            className="border-2 border-gray-300 text-sm px-2"
          >
            <option value="relevant">Sort by: Relevant</option>
            <option value="low-high">Sort by: Low to High</option>
            <option value="high-low">Sort by: High to Low</option>
          </select>
        </div>

        {/* Display Filtered Products */}
        <div className="grid grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4 gap-y-6">
          {filterProducts.map((item, index) => (
            <ProductItem
              key={index}
              id={item._id}
              image={item.image}
              name={item.name}
              price={item.price}
            />
          ))}
        </div>
      </div>
    </div>
  );
};

export default Collection;
