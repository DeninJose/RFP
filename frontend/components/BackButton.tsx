"use client";

import Link from "next/link";

interface BackButtonProps {
  href?: string;
  label?: string;
}

export default function BackButton({ href, label = "Back" }: BackButtonProps) {
  return (
    <div className="mb-4">
      {href ? (
        <Link href={href}>
          <button className="flex items-center text-gray-600 hover:text-gray-800 transition">
            <svg
              className="w-5 h-5 mr-1"
              fill="none"
              stroke="currentColor"
              viewBox="0 0 24 24"
            >
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth={2}
                d="M15 19l-7-7 7-7"
              />
            </svg>
            {label}
          </button>
        </Link>
      ) : (
        <button
          onClick={() => window.history.back()}
          className="flex items-center text-gray-600 hover:text-gray-800 transition"
        >
          <svg
            className="w-5 h-5 mr-1"
            fill="none"
            stroke="currentColor"
            viewBox="0 0 24 24"
          >
            <path
              strokeLinecap="round"
              strokeLinejoin="round"
              strokeWidth={2}
              d="M15 19l-7-7 7-7"
            />
          </svg>
          {label}
        </button>
      )}
    </div>
  );
}
