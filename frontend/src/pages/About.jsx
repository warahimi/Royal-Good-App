import React from "react";
import Title from "../components/Title";
import { assets } from "../assets/assets";
import NewsletterBox from "../components/NewsletterBox";

const About = () => {
  return (
    <div>
      <div className="text-2xl text-center pt-8 border-t">
        <Title text1={"ABOUT"} text2={"US"} />
      </div>

      <div className="my-10 flex flex-col md:flex-row gap-16">
        <img
          className="w-full md:max-w-[450px]"
          src={assets.about_img}
          alt=""
        />
        <div className="flex flex-col justify-center gap-6 md:w-2/4 text-gray-600">
          <p>
            <strong>Royal Goods</strong> was founded with a vision to transform
            online shopping into an experience of elegance, ease, and
            reliability. Our journey started with a simple goal: to create a
            space where customers can explore, connect, and shop a curated
            selection of premium products, all from the comfort of their own
            homes. Since our founding, we’ve dedicated ourselves to selecting
            only the finest products across a variety of categories, including
            fashion, beauty, electronics, and home essentials. Each item in our
            collection is chosen with care, sourced from trusted brands and
            suppliers, ensuring that every purchase from Royal Goods reflects
            quality and style.
          </p>
          <b className="text-gray-800">Our Mission</b>
          <p>
            At <strong>Royal Goods</strong>, our mission is to offer our
            customers choice, convenience, and peace of mind. We strive to
            provide an exceptional shopping experience, making every step—from
            browsing and ordering to delivery and support—as seamless and
            enjoyable as possible. With Royal Goods, discover the joy of finding
            exactly what you need, when you need it, with the assurance of
            quality at every turn.
          </p>
        </div>
      </div>

      <div className="text-xl py-4">
        <Title text1={"WHY"} text2={"CHOOSE US"} />
      </div>

      <div className="flex flex-col md:flex-row text-sm mb-20">
        <div className="border px-10 md:px-16 py-8 sm:py-20 flex flex-col gap-5">
          <b>Quality Assurance:</b>
          <p className="text-gray-600">
            We meticulously select and vet each product to ensure it meets our
            stringent quality standards.
          </p>
        </div>
        <div className="border px-10 md:px-16 py-8 sm:py-20 flex flex-col gap-5">
          <b>Convenience: </b>
          <p className="text-gray-600">
            With our user-friendly interface and hassle-free ordering process,
            shopping has never been easier.
          </p>
        </div>
        <div className="border px-10 md:px-16 py-8 sm:py-20 flex flex-col gap-5">
          <b>Exceptional Customer Service:</b>
          <p className="text-gray-600">
            Our team of dedicated professionals is here to assist you the way,
            ensuring your satisfaction is our top priority.
          </p>
        </div>
      </div>

      <NewsletterBox />
    </div>
  );
};

export default About;
