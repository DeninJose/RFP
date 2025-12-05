"use client";

import { useState } from "react";
import Link from "next/link";
import { procurementsApi } from "@/lib/api/procurements";

export default function Home() {
  const [text, setText] = useState("");
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState<string | null>(null);

  const onSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    if (!text.trim()) {
      return alert("Please enter your procurement requirements.");
    }

    setLoading(true);
    setError(null);

    try {
      const procurement = await procurementsApi.create({ queryText: text });
      console.log("Created procurement:", procurement);
      alert("Procurement created successfully!");
      setText("");
    } catch (err) {
      const errorMessage =
        err instanceof Error ? err.message : "Failed to create procurement";
      setError(errorMessage);
      console.error("Error:", err);
    } finally {
      setLoading(false);
    }
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

        {error && (
          <div className="mt-4 p-3 bg-red-100 text-red-700 rounded-lg">
            {error}
          </div>
        )}

        <form onSubmit={onSubmit} className="mt-6">
          <textarea
            className="w-full h-56 p-4 border rounded-xl resize-vertical focus:outline-none focus:ring-2 focus:ring-blue-500 text-gray-800"
            placeholder="Example: Need 20 laptops with 16GB RAM, 512GB SSD, delivery in 15 days..."
            value={text}
            onChange={(e) => setText(e.target.value)}
            disabled={loading}
          />

          <button
            type="submit"
            disabled={loading}
            className="w-full mt-4 bg-blue-600 hover:bg-blue-700 text-white py-3 rounded-xl text-lg transition disabled:opacity-50 disabled:cursor-not-allowed"
          >
            {loading ? "Processing..." : "Submit Request"}
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
