export interface Vendor {
    vendorId: string;
    name: string;
    email: string;
    phone: string;
    website: string;
    categories: string[];
    status: string;
    rating: number;
    additionalInfo: Record<string, string>;
    createdAt: string;
    updatedAt: string;
}
