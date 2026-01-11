//Fonction socket
#include <sys/types.h>
#include <sys/socket.h>

//Fonction bind
#include <netinet/in.h>
#include <arpa/inet.h>

int main() {
    //Fonction socket
    int sock;
    //Fonction bind et connect
    int ret;
    struct sockaddr_in addr;
    //Fonction accept
    int size;
    int cnx;
    struct sockaddr_in conn_addr;
    
    //Fonction socket
    sock = socket(AF_INET, SOCK_STREAM, 0);
    //Fonction bind
    addr.sin_addr.s_addr = inet_addr("127.0.0.1");
    addr.sin_family = AF_INET;
    addr.sin_port = htons(8080);
    //ret = bind(sock, (struct sockaddr *)&addr, sizeof(addr));
    ret = connect(sock, (struct sockaddr *)&addr, sizeof(addr));
    //Fonction listen
    ret = listen(sock, 1);
    //Fonction accept
    size = sizeof(conn_addr);
    cnx = accept(sock, (struct sockaddr *)&conn_addr, (socklen_t *)&size);
}