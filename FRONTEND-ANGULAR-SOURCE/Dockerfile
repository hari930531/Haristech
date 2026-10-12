# ---------- Stage 1: Build the Angular app ----------
FROM node:20-alpine AS builder

# Set working directory
WORKDIR /app

# Copy package files first for caching
COPY package*.json ./

# Install dependencies (omit dev dependencies for smaller build)
RUN npm ci

# Copy the rest of the source code
COPY . .

RUN npm run build


# ---------- Stage 2: Serve with Nginx ----------
FROM nginx:1.27-alpine

# Copy built Angular files to Nginx’s html directory
COPY --from=builder /app/dist/simplybyte /usr/share/nginx/html

# Expose port 80 (default for Nginx)
EXPOSE 80

# Run Nginx in foreground
CMD ["nginx", "-g", "daemon off;"]
