import React, { useContext, useEffect, useState } from "react"; // Import React, hooks, and other necessary modules
import { ShopContext } from "../context/ShopContext"; // Import ShopContext to access shared state and functions
import { assets } from "../assets/assets"; // Import assets, which may include icons or images for the search bar
import { useLocation } from "react-router-dom"; // Import useLocation to access the current route information

// Define the SearchBar component
const SearchBar = () => {
  const location = useLocation(); // Get the current URL location object to determine the current route
  const [visible, setVisible] = useState(false); // Local state to control the visibility of the search bar
  const { search, setSearch, showSearch, setShowSearch } =
    useContext(ShopContext);
  // Access global state and functions from ShopContext, such as search, setSearch, showSearch, and setShowSearch

  // useEffect to control search bar visibility based on the route
  useEffect(() => {
    // Show the search bar only on the /collection page if showSearch is true
    if (location.pathname.includes("collection") && showSearch) {
      setVisible(true); // Set visible to true if the user is on the /collection page and showSearch is enabled
    } else {
      setVisible(false); // Hide the search bar on other pages or if showSearch is false
    }
  }, [location, showSearch]); // Run this effect when the location or showSearch changes

  // Render the search bar if showSearch and visible are true, otherwise render nothing (null)
  return showSearch && visible ? (
    <div className="border-t border-b bg-gray-50 text-center">
      {/* Wrapper div for the search bar, styled with borders and background color */}
      <div className="inline-flex items-center justify-center border border-gray-400 px-5 py-2 my-5 mx-3 rounded-full w-3/4 sm:w-1/2">
        {/* Input and search icon container, centered and styled with border and padding */}
        <input
          className="flex-1 outline-none bg-inherit text-sm"
          onChange={(e) => setSearch(e.target.value)} // Update the search state when the input value changes
          value={search} // Controlled input, bound to the search state
          type="text"
          placeholder="Search" // Placeholder text for the search bar
        />
        <img className="w-4" src={assets.search_icon} alt="" />{" "}
        {/* Search icon */}
      </div>
      <img
        onClick={() => setShowSearch(false)} // Close the search bar when the cross icon is clicked
        className="inline w-3 cursor-pointer"
        src={assets.cross_icon}
        alt=""
      />
    </div>
  ) : null; // If showSearch or visible is false, return null (render nothing)
};

export default SearchBar; // Export the SearchBar component as the default export
