"use client";

import Link from "next/link";
import { useEffect, useState } from "react";
import { procurementsApi } from "@/lib/api/procurements";
import { Procurement } from "@/lib/types";
import BackButton from "@/components/BackButton";

export default function ProcurementsPage() {
  const [procurements, setProcurements] = useState<Procurement[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    const fetchProcurements = async () => {
      try {
        const data = await procurementsApi.getAll();
        setProcurements(data);
      } catch (err) {
        const errorMessage =
          err instanceof Error ? err.message : "Failed to load procurements";
        setError(errorMessage);
        console.error("Error fetching procurements:", err);
      } finally {
        setLoading(false);
      }
    };

    fetchProcurements();
  }, []);

  return (
    <div className="min-h-screen flex items-start justify-center bg-gray-100 p-6">
      <div className="mt-20 bg-white w-full max-w-xl p-8 rounded-2xl shadow-lg">
        <BackButton href="/" label="Back to Home" />

        <h1 className="text-3xl font-semibold text-center text-gray-800">
          Procurements List
        </h1>
        <p className="text-center text-gray-600 mt-1">
          Here are the current procurement requests.
        </p>

        {loading && (
          <div className="mt-6 text-center text-gray-600">Loading...</div>
        )}

        {error && (
          <div className="mt-6 p-3 bg-red-100 text-red-700 rounded-lg">
            {error}
          </div>
        )}

        {!loading && !error && procurements.length === 0 && (
          <div className="mt-6 text-center text-gray-600">
            No procurements found. Create one to get started!
          </div>
        )}

        {!loading && !error && procurements.length > 0 && (
          <ul className="mt-6 space-y-4">
            {procurements.map((item) => (
              <li key={item.procurementId}>
                <Link href={`/procurements/${item.procurementId}`}>
                  <div className="border rounded-xl p-4 hover:bg-gray-50 cursor-pointer transition">
                    <h2 className="text-lg font-semibold text-gray-800">
                      {item.name}
                    </h2>
                    <p className="text-gray-600">{item.description}</p>
                  </div>
                </Link>
              </li>
            ))}
          </ul>
        )}
      </div>
    </div>
  );
}
