<?php
/**
 * File untuk penanganan konfigurasi
 * Misanya environment, database
 */

/**
 * Value yang diperbolehkan:
 *		development
 *		testing
 *		production
 **/
define('ENVIRONMENT', 'development');

/**
 * Alamat web home, tanpa tanda / di belakang
 */
define('SITEURL', '//localhost/IF3110-Tubes-I/src');

/**
 * Database configuration
 */
$CONFIG['mysql']['database'] = 'tubes1_wbd';
$CONFIG['mysql']['host'] = 'localhost';
$CONFIG['mysql']['username'] = 'root';
$CONFIG['mysql']['password'] = '';