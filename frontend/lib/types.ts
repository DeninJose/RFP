export interface Product {
  productId: string;
  procurementId: string;
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
  createdAt: string;
  updatedAt: string;
}

export interface ProcurementDto {
    procurement: Procurement;
    products: Product[];
}
