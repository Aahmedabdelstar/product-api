# 🚀 Deployment Guide for Product API

This guide will help you deploy your Spring Boot Product API so your mobile team can access it remotely.

---

## 📱 **What Your Mobile Team Will Get**
After deployment, your mobile team will receive a public URL like:
- `https://your-app-name.onrender.com/api/products`
- They can use this URL in their mobile app to fetch product data

---

## ⚡ **Option 1: Deploy with Render.com (RECOMMENDED - FREE)**

### **Prerequisites**
1. Create a GitHub account (if you don't have one)
2. Create a Render account at https://render.com

### **Step-by-Step Instructions**

#### **1. Push Your Code to GitHub**

```bash
# Initialize git repository (if not already done)
cd /Users/ahmedabdelstar/Downloads/product-api
git init

# Add all files
git add .

# Commit your code
git commit -m "Initial commit - Product API ready for deployment"

# Create a new repository on GitHub (via GitHub website)
# Then link it to your local repository
git remote add origin https://github.com/YOUR_USERNAME/product-api.git

# Push your code
git push -u origin main
```

#### **2. Deploy on Render**

1. **Login to Render**: Go to https://render.com and sign in with GitHub

2. **Create New Web Service**:
   - Click "New +" → "Web Service"
   - Connect your GitHub repository (`product-api`)
   - Render will auto-detect it's a Java/Maven project

3. **Configure the Service**:
   ```
   Name: product-api (or any name you prefer)
   Region: Choose closest to your team
   Branch: main
   Runtime: Java
   Build Command: ./mvnw clean package -DskipTests
   Start Command: java -jar target/product-api-0.0.1-SNAPSHOT.jar
   Instance Type: Free
   ```

4. **Environment Variables** (Add these):
   ```
   JAVA_VERSION=21
   MAVEN_OPTS=-Xmx512m
   ```

5. **Click "Create Web Service"**

6. **Wait for Deployment** (5-10 minutes)
   - Render will build and deploy your application
   - You'll get a URL like: `https://product-api-xxxx.onrender.com`

#### **3. Test Your Deployment**

After deployment completes, test these endpoints:

```bash
# Get all products
curl https://your-app-name.onrender.com/api/products

# Get product by ID
curl https://your-app-name.onrender.com/api/products/1
```

#### **4. Share with Mobile Team**

Give your mobile team:
- **Base URL**: `https://your-app-name.onrender.com`
- **Endpoints**:
  - `GET /api/products` - Get all products
  - `GET /api/products/{id}` - Get product by ID
  - `POST /api/products` - Create new product
  - `PUT /api/products/{id}` - Update product
  - `DELETE /api/products/{id}` - Delete product

---

## ⚡ **Option 2: Deploy with Railway.app (FREE $5 CREDIT)**

### **Step-by-Step Instructions**

#### **1. Push Your Code to GitHub** (same as Option 1)

#### **2. Deploy on Railway**

1. **Login to Railway**: Go to https://railway.app and sign in with GitHub

2. **Create New Project**:
   - Click "New Project"
   - Select "Deploy from GitHub repo"
   - Choose your `product-api` repository

3. **Configure Settings**:
   - Railway will auto-detect Java/Maven
   - Click on your service → Settings
   - Add environment variable: `PORT=8080`

4. **Generate Domain**:
   - Go to "Settings" tab
   - Under "Networking", click "Generate Domain"
   - You'll get a URL like: `https://product-api.up.railway.app`

5. **Deploy**:
   - Railway automatically deploys on push
   - Check the "Deployments" tab for build logs

---

## ⚡ **Option 3: Deploy with Heroku**

### **Prerequisites**
1. Create Heroku account at https://heroku.com
2. Install Heroku CLI: https://devcenter.heroku.com/articles/heroku-cli

### **Step-by-Step Instructions**

```bash
# Login to Heroku
heroku login

# Create Heroku app
heroku create your-product-api

# Set Java version
heroku config:set JAVA_VERSION=21

# Push to Heroku
git push heroku main

# Your API will be available at:
# https://your-product-api.herokuapp.com
```

---

## 🔧 **Testing Your Deployed API**

### **Using cURL**
```bash
# Get all products
curl https://YOUR-DEPLOYMENT-URL/api/products

# Create a new product
curl -X POST https://YOUR-DEPLOYMENT-URL/api/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Test Product",
    "description": "Product from API",
    "price": 99.99,
    "stockQuantity": 10
  }'
```

### **Using Browser**
Simply visit:
```
https://YOUR-DEPLOYMENT-URL/api/products
```

---

## 📱 **Mobile Team Integration Examples**

### **Android (Kotlin)**
```kotlin
val apiUrl = "https://your-app-name.onrender.com"

// Using Retrofit
interface ProductApi {
    @GET("/api/products")
    suspend fun getProducts(): List<Product>
    
    @GET("/api/products/{id}")
    suspend fun getProduct(@Path("id") id: Long): Product
}
```

### **iOS (Swift)**
```swift
let baseURL = "https://your-app-name.onrender.com"

func fetchProducts() {
    guard let url = URL(string: "\(baseURL)/api/products") else { return }
    
    URLSession.shared.dataTask(with: url) { data, response, error in
        // Handle response
    }.resume()
}
```

### **React Native**
```javascript
const API_URL = 'https://your-app-name.onrender.com';

fetch(`${API_URL}/api/products`)
  .then(response => response.json())
  .then(data => console.log(data))
  .catch(error => console.error(error));
```

---

## ⚠️ **Important Notes**

### **1. Database Persistence**
Your current setup uses **H2 in-memory database**, which means:
- ✅ Good for testing and development
- ❌ Data is lost when the server restarts
- ❌ Not suitable for production with real data

**For production**, consider upgrading to:
- PostgreSQL (free tier available on Render/Railway)
- MySQL
- MongoDB

### **2. Free Tier Limitations**

**Render Free Tier**:
- App sleeps after 15 minutes of inactivity
- First request after sleep takes ~30 seconds (cold start)
- 750 hours/month free

**Railway**:
- $5 free credit/month
- No sleep, always active

### **3. CORS Configuration**
I've already added CORS configuration to allow your mobile app to access the API from any origin. In production, you should restrict this to specific domains.

---

## 🔄 **Updating Your Deployed API**

After initial deployment, whenever you make changes:

1. **Commit changes**:
   ```bash
   git add .
   git commit -m "Description of changes"
   git push origin main
   ```

2. **Automatic deployment**:
   - Render/Railway will automatically detect the push and redeploy
   - No manual intervention needed!

---

## 🆘 **Troubleshooting**

### **Build Fails**
- Check Java version is set to 21
- Verify pom.xml is correct
- Check build logs for errors

### **API Returns 404**
- Ensure you're using correct endpoint: `/api/products`
- Check application logs

### **App Crashes on Startup**
- Check application logs in Render/Railway dashboard
- Verify environment variables are set correctly

---

## 📞 **Need Help?**

- **Render Docs**: https://render.com/docs/deploy-spring
- **Railway Docs**: https://docs.railway.app
- **Spring Boot Docs**: https://spring.io/guides/gs/spring-boot/

---

## ✅ **Quick Checklist**

- [ ] Code pushed to GitHub
- [ ] Deployment platform account created (Render/Railway)
- [ ] Service configured and deployed
- [ ] Deployment successful (check build logs)
- [ ] API tested with cURL or browser
- [ ] URL shared with mobile team
- [ ] Mobile team can access the API

---

**Good luck with your deployment! 🚀**

