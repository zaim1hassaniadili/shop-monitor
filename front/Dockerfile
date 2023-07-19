FROM node:16.10-alpine As builder
WORKDIR /app
COPY package.json ./
RUN npm install
COPY . .
RUN npm run build

FROM nginx:1.15.8-alpine
COPY --from=builder /usr/src/app/dist/ /usr/share/nginx/html
CMD ["nginx", "-g", "daemon off;"]
