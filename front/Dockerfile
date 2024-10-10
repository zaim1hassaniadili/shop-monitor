FROM node:16.10-alpine As builder
WORKDIR /app
COPY package*.json ./
RUN npm install
RUN npm install -g @angular/cli@17 | echo "good"
COPY . .
RUN npm run build --prod
RUN ls

FROM nginx:1.15.8-alpine
RUN rm /usr/share/nginx/html/index.html
COPY --from=builder /app/dist/shop-monitor/* /usr/share/nginx/html
COPY --from=builder /app/nginx.conf /etc/nginx/nginx.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
