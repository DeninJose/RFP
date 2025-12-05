export interface Product {
  productId: string;
  name: string;
  quantity: number;
  properties: Record<string, string>;
  createdAt: string;
  updatedAt: string;
}

export interface Procurement {
  procurementId: string;
  name: string;
  description: string;
  status: string;
  budget: number;
  deadline: string;
  properties: Record<string, string>;
  products: Product[];
  createdAt: string;
  updatedAt: string;
}
