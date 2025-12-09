import { api } from './client';
import { Vendor } from '../types/vendor';

export interface CreateVendorRequest {
  name: string;
  email: string;
  phone: string;
  website: string;
  categories: string[];
  status: string;
  rating: number;
  additionalInfo: Record<string, string>;
}

export const vendorsApi = {
  getAll: () => api.get<Vendor[]>('/api/v1/vendors'),

  getById: (id: string) => api.get<Vendor>(`/api/v1/vendors/${id}`),

  create: (data: CreateVendorRequest) =>
    api.post<void>('/api/v1/vendors', data),

  delete: (id: string) => api.delete(`/api/v1/vendors/${id}`),
};
