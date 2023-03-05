FROM node:16-alpine 
WORKDIR /app
COPY app/. /app/
RUN npm ci
RUN npm run build
EXPOSE 3000
CMD [ "npx", "serve", "build" ]