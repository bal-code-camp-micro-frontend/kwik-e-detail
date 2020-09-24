FROM bitnami/nginx:latest
COPY my_server_block.conf /opt/bitnami/nginx/conf/server_blocks/my_server_block.conf
COPY /dist/kwik-e-detail /opt/html/
