"use client";

import { useState } from "react";
import Link from "next/link";

export default function Home() {
  const [text, setText] = useState("");

  const onSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    if (!text.trim())
      return alert("Please enter your procurement requirements.");

    // TODO: call backend AI API endpoint
    console.log("Submitting:", text);
  };

  return (
    <div className="min-h-screen flex items-start justify-center bg-gray-100 p-6">
      <div className="mt-20 bg-white w-full max-w-xl p-8 rounded-2xl shadow-lg">
        <h1 className="text-3xl font-semibold text-center text-gray-800">
          Procurement Request
        </h1>
        <p className="text-center text-gray-600 mt-1">
          Describe what you want to procure. Our AI will process it.
        </p>

        <form onSubmit={onSubmit} className="mt-6">
          <textarea
            className="w-full h-56 p-4 border rounded-xl resize-vertical focus:outline-none focus:ring-2 focus:ring-blue-500 text-gray-800"
            placeholder="Example: Need 20 laptops with 16GB RAM, 512GB SSD, delivery in 15 days..."
            value={text}
            onChange={(e) => setText(e.target.value)}
          />

          <button
            type="submit"
            className="w-full mt-4 bg-blue-600 hover:bg-blue-700 text-white py-3 rounded-xl text-lg transition"
          >
            Submit Request
          </button>
        </form>

        <Link href="/procurements">
          <button className="w-full mt-3 bg-gray-600 hover:bg-gray-700 text-white py-3 rounded-xl text-lg transition">
            View Procurements
          </button>
        </Link>
      </div>
    </div>
  );
}
