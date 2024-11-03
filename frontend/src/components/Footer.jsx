import React from "react";
import { assets } from "../assets/assets";
import { Link } from "react-router-dom";

const Footer = () => {
  return (
    <div>
      <div className="flex flex-col sm:grid grid-cols-[3fr_1fr_1fr] gap-14 my-10 mt-40 text-sm">
        <div>
          <img className="mb-5 w-32" src={assets.logo} alt="" />
          <p className="w-full md:w-2/3 text-gray-600">
            Royal Goods is your destination for luxury products that blend
            style, quality, and innovation. From exclusive collections to
            everyday essentials, we curate items that elevate your lifestyle
            with elegance and sophistication. Committed to exceptional service
            and premium craftsmanship, Royal Goods offers an unparalleled
            shopping experience tailored to meet your discerning tastes. Explore
            our range and indulge in the essence of modern luxury.
          </p>
        </div>

        <div>
          <p className="text-xl font-medium mb-5 mt-6">ROYAL GOODS</p>
          <ul className="flex flex-col gap-1 text-gray-600">
            <Link to="/">
              <li>Home</li>
            </Link>
            <Link to="/about">
              <li>About us</li>
            </Link>
            <li>Delivery</li>
            <li>Privacy policy</li>
          </ul>
        </div>

        <div>
          <p className="text-xl font-medium mb-5 mt-6">GET IN TOUCH</p>
          <ul className="flex flex-col gap-1 text-gray-600">
            <li>(+1) 253 310 5930</li>
            <li>info@royalgoodsusa.com</li>
          </ul>
        </div>
      </div>

      <div>
        <hr />
        <p className="py-5 text-sm text-center">
          Copyright 2024@ royalgoodsusa.com - All Right Reserved.
        </p>
      </div>
    </div>
  );
};

export default Footer;
