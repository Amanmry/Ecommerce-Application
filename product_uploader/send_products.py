import requests

# Replace this with your actual API endpoint
API_URL = "http://localhost:9193/api/v1/products/add"

# List of mock product payloads
products = [
    {
        "name": "TV",
        "brand": "LG",
        "price": "150",
        "inventory": "35",
        "description": "LG smart television",
        "category": "Electronics"
    },
    {
        "name": "Refrigerator",
        "brand": "Samsung",
        "price": "480",
        "inventory": "20",
        "description": "Samsung double-door refrigerator with digital inverter technology",
        "category": "Electronics"
    },
    {
        "name": "Washing Machine",
        "brand": "Whirlpool",
        "price": "350",
        "inventory": "15",
        "description": "6.5 kg fully automatic top-load washing machine",
        "category": "Home Appliances"
    },
    {
        "name": "Bluetooth Speaker",
        "brand": "JBL",
        "price": "120",
        "inventory": "50",
        "description": "Portable JBL Go 3 wireless Bluetooth speaker with rich bass",
        "category": "Audio"
    },
    {
        "name": "Laptop",
        "brand": "HP",
        "price": "900",
        "inventory": "25",
        "description": "HP Pavilion 15 with Intel i5, 16GB RAM, 512GB SSD",
        "category": "Computers"
    },
    {
        "name": "Smartphone",
        "brand": "Apple",
        "price": "1200",
        "inventory": "40",
        "description": "Apple iPhone 15 with A17 Bionic chip and Super Retina display",
        "category": "Mobiles"
    },
    {
        "name": "Microwave Oven",
        "brand": "Panasonic",
        "price": "180",
        "inventory": "18",
        "description": "Panasonic 23L convection microwave oven with auto cook menu",
        "category": "Home Appliances"
    },
    {
        "name": "Gaming Console",
        "brand": "Sony",
        "price": "499",
        "inventory": "12",
        "description": "Sony PlayStation 5 console with DualSense wireless controller",
        "category": "Gaming"
    },
    {
        "name": "Vacuum Cleaner",
        "brand": "Dyson",
        "price": "450",
        "inventory": "10",
        "description": "Dyson V11 cordless vacuum cleaner with advanced filtration",
        "category": "Home Appliances"
    },
    {
        "name": "Smartwatch",
        "brand": "Garmin",
        "price": "250",
        "inventory": "30",
        "description": "Garmin Venu 2 with GPS, heart rate monitor, and AMOLED display",
        "category": "Wearables"
    }
]

# Loop through each product and send it
for product in products:
    try:
        response = requests.post(API_URL, json=product)
        if response.status_code == 200 or response.status_code == 201:
            print(f"Successfully added: {product['name']}")
        else:
            print(f"Failed to add {product['name']} (Status {response.status_code})")
            print("Response:", response.text)
    except Exception as e:
        print(f"Error sending {product['name']}: {e}")
