# ⚡ Quick Start - Deploy in 10 Minutes

This guide will get your Product API online and accessible by your mobile team in about 10 minutes.

## 🎯 What You'll Get

After following these steps, you'll have:
- ✅ A live API accessible from anywhere
- ✅ A public URL like: `https://product-api-xxxx.onrender.com`
- ✅ Your mobile team can start integrating immediately

---

## 🚀 3-Step Deployment (Render.com - Free)

### **Step 1: Push to GitHub** (2 minutes)

```bash
# Navigate to your project
cd /Users/ahmedabdelstar/Downloads/product-api

# Run the setup script
./deploy-setup.sh
```

Then:
1. Go to https://github.com/new
2. Create a new repository named `product-api`
3. Keep it **Public** (or Private if preferred)
4. **DO NOT** check "Initialize with README"
5. Click **Create repository**

Copy the commands GitHub shows you (they look like this):

```bash
git remote add origin https://github.com/YOUR_USERNAME/product-api.git
git branch -M main
git push -u origin main
```

---

### **Step 2: Deploy on Render** (3 minutes)

1. **Go to**: https://render.com
2. **Sign up** with your GitHub account (it's free!)
3. Click **"New +"** → **"Web Service"**
4. Click **"Connect GitHub"** and select your `product-api` repository
5. Fill in these settings:

   ```
   Name: product-api
   Region: Choose closest to your team
   Branch: main
   Runtime: Docker (or Java)
   Build Command: ./mvnw clean package -DskipTests
   Start Command: java -jar target/product-api-0.0.1-SNAPSHOT.jar
   Instance Type: Free
   ```

6. Add Environment Variables:
   - Click **"Add Environment Variable"**
   - Key: `JAVA_VERSION`, Value: `21`

7. Click **"Create Web Service"**

---

### **Step 3: Test & Share** (1 minute)

Wait 5-10 minutes for Render to build and deploy. You'll see:
- ✅ "Build successful"
- ✅ "Deploy live"

Your API URL will be: `https://product-api-xxxx.onrender.com`

**Test it:**

```bash
curl https://YOUR-URL-HERE.onrender.com/api/products
```

You should see JSON with product data! 🎉

**Share with mobile team:**

Send them this:
```
Base URL: https://your-app-name.onrender.com

Endpoints:
- GET  /api/products          (Get all products)
- GET  /api/products/{id}     (Get one product)
- POST /api/products          (Create product)
- PUT  /api/products/{id}     (Update product)
- DELETE /api/products/{id}   (Delete product)
```

---

## 🔄 Alternative: Railway.app (Even Easier!)

If Render doesn't work, try Railway:

1. Go to https://railway.app
2. Sign in with GitHub
3. Click **"New Project"** → **"Deploy from GitHub repo"**
4. Select your `product-api` repository
5. Railway auto-deploys! ✨
6. Go to **Settings** → **Networking** → **Generate Domain**
7. Your API is live at: `https://product-api.up.railway.app`

**Note**: Railway gives you $5 free credit/month

---

## 📱 Mobile Team Integration Examples

### Android (Kotlin)
```kotlin
const val BASE_URL = "https://product-api-xxxx.onrender.com"

// Using Retrofit
interface ProductApi {
    @GET("/api/products")
    suspend fun getProducts(): List<Product>
}
```

### iOS (Swift)
```swift
let baseURL = "https://product-api-xxxx.onrender.com"

func fetchProducts() {
    guard let url = URL(string: "\(baseURL)/api/products") else { return }
    URLSession.shared.dataTask(with: url) { data, _, _ in
        // Handle response
    }.resume()
}
```

### React Native / Flutter
```javascript
const API_URL = 'https://product-api-xxxx.onrender.com';

fetch(`${API_URL}/api/products`)
  .then(res => res.json())
  .then(data => console.log(data));
```

---

## ⚠️ Important Things to Know

### **Free Tier Limitations**

**Render Free Tier**:
- ✅ Completely free
- ⏰ App "sleeps" after 15 minutes of no traffic
- 🐌 First request after sleep takes ~30 seconds (cold start)
- 💡 Good for: Testing, demos, low-traffic apps

**Railway**:
- 💰 $5 free credit/month
- ✅ No sleep - always active
- 💡 Good for: Active development, small production apps

### **Database Notice**

Your app uses **H2 in-memory database**:
- ✅ Perfect for testing and demos
- ❌ Data is **lost** when server restarts
- ❌ Not suitable for production with real user data

**For production**: Upgrade to PostgreSQL (both Render and Railway offer free PostgreSQL)

### **CORS is Already Configured**

Your API is already configured to accept requests from mobile apps (CORS enabled).

---

## 🔍 Testing Your Deployed API

### Using cURL
```bash
# Get all products
curl https://YOUR-URL.onrender.com/api/products

# Get specific product
curl https://YOUR-URL.onrender.com/api/products/1

# Create new product
curl -X POST https://YOUR-URL.onrender.com/api/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "New Product",
    "description": "From mobile app",
    "price": 149.99,
    "stockQuantity": 25
  }'
```

### Using Browser
Just open: `https://YOUR-URL.onrender.com/api/products` in any browser!

---

## 🆘 Troubleshooting

### "Build Failed"
- Check that Java 21 is set in environment variables
- Look at build logs in Render dashboard
- Make sure all files are pushed to GitHub

### "404 Not Found"
- Use `/api/products` not just `/products`
- Wait for deployment to complete (check Render logs)

### "Application Error"
- Check application logs in Render dashboard
- Verify environment variables are set

### Still Having Issues?
- Check the detailed [DEPLOYMENT_GUIDE.md](DEPLOYMENT_GUIDE.md)
- Render docs: https://render.com/docs/deploy-spring
- Railway docs: https://docs.railway.app

---

## ✅ Checklist

- [ ] Code pushed to GitHub
- [ ] Render/Railway account created
- [ ] Web service deployed
- [ ] API tested with curl/browser
- [ ] URL shared with mobile team
- [ ] Mobile team confirmed they can access it

---

## 🎉 You're Done!

Your API is now live and accessible from anywhere in the world!

**What's Next?**
- Share the URL with your mobile team
- Monitor usage in Render/Railway dashboard
- Consider upgrading database for production use

**Need Help?** Check [DEPLOYMENT_GUIDE.md](DEPLOYMENT_GUIDE.md) for detailed instructions.

---

**Happy coding! 🚀**

