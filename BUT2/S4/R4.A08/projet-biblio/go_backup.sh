#!/bin/bash
docker run --rm --network app_network bigpapoo/r408-php:8.2-apache php /var/www/html/backup.php
