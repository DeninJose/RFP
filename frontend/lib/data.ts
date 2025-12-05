import { Procurement } from "./types";

export const procurements: Procurement[] = [
  {
    procurementId: "1",
    name: "Tech Inventory",
    description: "Tech products like laptops and monitors",
    status: "open",
    budget: 10000,
    deadline: "2024-12-31",
    properties: {
        "Warranty": "2 years",
    },
    createdAt: new Date().toISOString(),
    updatedAt: new Date().toISOString(),
    products: [
        {
            productId: "1",
            name: "Laptop",
            quantity: 20,
            properties: {
                "RAM": "16GB",
                "Storage": "512GB SSD",
            },
            createdAt: new Date().toISOString(),
            updatedAt: new Date().toISOString(),
        }
    ],
  },
  {
    procurementId: "2",
    name: "Stationary Supplies",
    description: "Stationary items like pens, notebooks, and folders",
    status: "open",
    budget: 10000,
    deadline: "2024-12-31",
    properties: {},
    products: [],
    createdAt: new Date().toISOString(),
    updatedAt: new Date().toISOString(),
  },
  {
    procurementId: "3",
    name: "Office Equipment",
    description: "Office equipment like chairs and desks",
    status: "open",
    budget: 10000,
    deadline: "2024-12-31",
    properties: {},
    products: [],
    createdAt: new Date().toISOString(),
    updatedAt: new Date().toISOString(),
  },
];
