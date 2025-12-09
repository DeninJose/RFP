"use client";

import { use, useEffect, useState } from "react";
import BackButton from "@/components/BackButton";
import { vendorsApi } from "@/lib/api/vendors";
import { Vendor } from "@/lib/types/vendor";

interface Params {
  procurementId: string;
}

export default function VendorsPage({ params }: { params: Promise<Params> }) {
  const { procurementId } = use(params);
  const [vendors, setVendors] = useState<Vendor[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    const fetchVendors = async () => {
      try {
        const data = await vendorsApi.getAll();
        setVendors(data);
      } catch (err) {
        setError(err instanceof Error ? err.message : "Failed to load vendors");
        console.error("Error fetching vendors:", err);
      } finally {
        setLoading(false);
      }
    };

    fetchVendors();
  }, []);

  if (loading) {
    return (
      <div className="min-h-screen flex items-start justify-center bg-gray-100 p-6">
        <div className="mt-20 bg-white w-full max-w-4xl p-8 rounded-2xl shadow-lg">
          <div className="text-center text-gray-600">Loading vendors...</div>
        </div>
      </div>
    );
  }

  return (
    <div className="min-h-screen flex items-start justify-center bg-gray-100 p-6">
      <div className="mt-20 bg-white w-full max-w-4xl p-8 rounded-2xl shadow-lg">
        <BackButton href={`/procurements/${procurementId}`} label="Back to Procurement" />

        <h1 className="text-3xl font-semibold text-center text-gray-800">
          Vendors
        </h1>
        <p className="text-center text-gray-600 mt-1">
          Browse and manage vendors for this procurement
        </p>

        {error && (
          <div className="mt-6 p-3 bg-red-100 text-red-700 rounded-lg">
            {error}
          </div>
        )}

        {!loading && !error && vendors.length === 0 && (
          <div className="mt-6 text-center text-gray-600">
            No vendors found. Add vendors to get started!
          </div>
        )}

        {!loading && !error && vendors.length > 0 && (
          <div className="mt-6 grid grid-cols-1 md:grid-cols-2 gap-4">
            {vendors.map((vendor) => (
              <div
                key={vendor.vendorId}
                className="border rounded-xl p-4 hover:bg-gray-50 transition"
              >
                <div className="flex justify-between items-start mb-2">
                  <h2 className="text-lg font-semibold text-gray-800">
                    {vendor.name}
                  </h2>
                  <span
                    className={`px-2 py-1 text-xs rounded-full ${
                      vendor.status === "ACTIVE"
                        ? "bg-green-100 text-green-700"
                        : vendor.status === "INACTIVE"
                        ? "bg-gray-100 text-gray-700"
                        : "bg-red-100 text-red-700"
                    }`}
                  >
                    {vendor.status}
                  </span>
                </div>

                <div className="space-y-1 text-sm text-gray-600">
                  {vendor.email && (
                    <div>
                      <span className="font-medium">Email:</span> {vendor.email}
                    </div>
                  )}
                  {vendor.phone && (
                    <div>
                      <span className="font-medium">Phone:</span> {vendor.phone}
                    </div>
                  )}
                  {vendor.website && (
                    <div>
                      <span className="font-medium">Website:</span>{" "}
                      <a
                        href={vendor.website}
                        target="_blank"
                        rel="noopener noreferrer"
                        className="text-blue-600 hover:underline"
                      >
                        {vendor.website}
                      </a>
                    </div>
                  )}
                  {vendor.rating > 0 && (
                    <div>
                      <span className="font-medium">Rating:</span>{" "}
                      {vendor.rating.toFixed(1)} / 5.0
                    </div>
                  )}
                  {vendor.categories && vendor.categories.length > 0 && (
                    <div className="flex flex-wrap gap-1 mt-2">
                      {vendor.categories.map((category, index) => (
                        <span
                          key={index}
                          className="px-2 py-1 bg-blue-100 text-blue-700 text-xs rounded"
                        >
                          {category}
                        </span>
                      ))}
                    </div>
                  )}
                </div>
              </div>
            ))}
          </div>
        )}
      </div>
    </div>
  );
}
