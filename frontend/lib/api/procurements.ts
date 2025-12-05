import { api } from './client';
import { Procurement, ProcurementDto } from '../types';

const PROCUREMENTS_URL = '/api/v1/procurements';

export interface CreateProcurementRequest {
  queryText: string;
}


export const procurementsApi = {
  getAll: () => api.get<Procurement[]>(PROCUREMENTS_URL),

  getById: (id: string) => api.get<ProcurementDto>(`${PROCUREMENTS_URL}/${id}`),

  create: (data: CreateProcurementRequest) =>
    api.post<Procurement>(PROCUREMENTS_URL, data),

  update: (id: string, data: Partial<Procurement>) =>
    api.put<Procurement>(`${PROCUREMENTS_URL}/${id}`, data),

  delete: (id: string) => api.delete(`${PROCUREMENTS_URL}/${id}`),
};
