#!/bin/bash

echo "🚀 Product API - Deployment Setup Script"
echo "=========================================="
echo ""

# Check if git is installed
if ! command -v git &> /dev/null
then
    echo "❌ Git is not installed. Please install Git first."
    exit 1
fi

echo "✅ Git is installed"
echo ""

# Initialize git repository if not already done
if [ ! -d .git ]; then
    echo "📦 Initializing Git repository..."
    git init
    echo "✅ Git repository initialized"
else
    echo "✅ Git repository already exists"
fi

echo ""
echo "📝 Adding files to Git..."
git add .

echo ""
echo "💾 Committing files..."
git commit -m "Initial commit - Product API ready for deployment"

echo ""
echo "=========================================="
echo "✅ Local setup complete!"
echo ""
echo "📋 Next Steps:"
echo ""
echo "1. Create a new repository on GitHub:"
echo "   👉 Go to https://github.com/new"
echo "   👉 Repository name: product-api"
echo "   👉 Keep it Public or Private (your choice)"
echo "   👉 DO NOT initialize with README"
echo "   👉 Click 'Create repository'"
echo ""
echo "2. After creating the repository on GitHub, run these commands:"
echo "   (Replace YOUR_USERNAME with your actual GitHub username)"
echo ""
echo "   git remote add origin https://github.com/YOUR_USERNAME/product-api.git"
echo "   git branch -M main"
echo "   git push -u origin main"
echo ""
echo "3. Then go to https://render.com or https://railway.app"
echo "   and follow the deployment guide in DEPLOYMENT_GUIDE.md"
echo ""
echo "=========================================="

