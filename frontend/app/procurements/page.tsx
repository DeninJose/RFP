"use client";

import Link from "next/link";
import { procurements } from "@/lib/data";
import BackButton from "@/components/BackButton";

export default function ProcurementsPage() {
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
        <ul className="mt-6 space-y-4">
          {procurements.map((item) => (
            <li key={item.procurementId}>
              <Link href={`/procurements/${item.procurementId}`}>
                <div className="border rounded-xl p-4 hover:bg-gray-50 cursor-pointer transition">
                  <h2 className="text-lg font-semibold text-gray-800">{item.name}</h2>
                  <p className="text-gray-600">{item.description}</p>
                </div>
              </Link>
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
}
