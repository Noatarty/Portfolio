#!/bin/bash
docker run --rm --network app_network -v $(pwd)/mvt:/mvt bigpapoo/r408-php:8.2-apache php /var/www/html/do_batch.php