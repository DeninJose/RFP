import { Product } from "@/lib/types";

interface ProductCardProps {
  product: Product;
}

export default function ProductCard({ product }: ProductCardProps) {
  return (
    <div className="border rounded-xl p-4 bg-gray-50">
      <div className="flex justify-between items-start mb-2">
        <h3 className="text-lg font-semibold text-gray-800">{product.name}</h3>
        <span className="text-sm text-gray-600">Qty: {product.quantity}</span>
      </div>

      {Object.keys(product.properties).length > 0 && (
        <div className="mt-2 space-y-1">
          {Object.entries(product.properties).map(([key, value]) => (
            <div key={key} className="text-sm">
              <span className="text-gray-700 font-medium">{key}: </span>
              <span className="text-gray-600">{value}</span>
            </div>
          ))}
        </div>
      )}
    </div>
  );
}
