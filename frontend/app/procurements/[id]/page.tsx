"use client";

import { procurements } from "@/lib/data";
import { use } from "react";
import ProductCard from "@/components/ProductCard";
import BackButton from "@/components/BackButton";

interface Params {
  id: string;
}

export default function ProcurementDetailPage({
  params,
}: {
  params: Promise<Params>;
}) {
  const { id } = use(params);
  const procurement = procurements.find((p) => p.procurementId === id);

  if (!procurement) {
    return (
      <div className="min-h-screen flex items-start justify-center bg-gray-100 p-6">
        <div className="mt-20 bg-white w-full max-w-2xl p-8 rounded-2xl shadow-lg">
          <h1 className="text-3xl font-semibold text-center text-gray-800">
            Procurement Not Found
          </h1>
        </div>
      </div>
    );
  }

  return (
    <div className="min-h-screen flex items-start justify-center bg-gray-100 p-6">
      <div className="mt-20 bg-white w-full max-w-2xl p-8 rounded-2xl shadow-lg">
        <BackButton href="/procurements" label="Back to Procurements" />

        <h1 className="text-3xl font-semibold text-gray-800">{procurement.name}</h1>
        <p className="text-gray-600 mt-2">{procurement.description}</p>

        <div className="mt-6 space-y-4">
          <div className="border-b pb-4">
            <h2 className="text-lg font-semibold text-gray-800">Budget</h2>
            <p className="text-gray-600">${procurement.budget.toLocaleString()}</p>
          </div>

          <div className="border-b pb-4">
            <h2 className="text-lg font-semibold text-gray-800">Last Date</h2>
            <p className="text-gray-600">{procurement.deadline}</p>
          </div>

          <div className="border-b pb-4">
            <h2 className="text-lg font-semibold text-gray-800">Properties</h2>
            {Object.keys(procurement.properties).length === 0 ? (
              <p className="text-gray-600">No properties defined</p>
            ) : (
              <div className="mt-2 space-y-2">
                {Object.entries(procurement.properties).map(([key, value]) => (
                  <div key={key}>
                    <span className="text-gray-700 font-medium">{key} : </span>
                    <span className="text-gray-600">{String(value)}</span>
                  </div>
                ))}
              </div>
            )}
          </div>

          <div>
            <h2 className="text-lg font-semibold text-gray-800">Products</h2>
            {procurement.products.length === 0 ? (
              <p className="text-gray-600">No products added yet</p>
            ) : (
              <div className="mt-2 space-y-3">
                {procurement.products.map((product) => (
                  <ProductCard key={product.productId} product={product} />
                ))}
              </div>
            )}
          </div>
        </div>
      </div>
    </div>
  );
}
