#include <sys/types.h>
#include <sys/socket.h>

int sock;
int ret;
int size;
int cnx;
struct sockaddr_in conn_addr;
size = sizeof(conn_addr);
cnx = accept(sock, (struct sockaddr *)&conn_addr, (socklen_t *)&size);

ret = listen(sock, 1);
sock = socket(AF_INET, SOCK_STREAM, 0);
addr.sin_addr.s_addr = inet_addr("127.0.0.1");
addr.sin_family = AF_INET;
addr.sin_port = htons(8080);
ret = bind(sock, (struct sockaddr *)&addr, sizeof(addr));