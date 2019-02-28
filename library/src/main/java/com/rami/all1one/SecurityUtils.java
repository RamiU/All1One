package com.rami.all1one;

import android.Manifest;
import android.app.KeyguardManager;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyPermanentlyInvalidatedException;
import android.security.keystore.KeyProperties;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Permissions;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.core.content.ContextCompat;

import static android.content.Context.FINGERPRINT_SERVICE;
import static android.content.Context.KEYGUARD_SERVICE;

public class SecurityUtils {


    ///////////////////////////////////////////////////////////////////////////
    // ENCRIPTACION
    ///////////////////////////////////////////////////////////////////////////

    public static class Encriptacion{

    }



    ///////////////////////////////////////////////////////////////////////////
    // FINGERPRINT
    ///////////////////////////////////////////////////////////////////////////

    @RequiresApi(api = Build.VERSION_CODES.M)
    public static class Fingerprint{
        private KeyStore keyStore;
        private Cipher cipher;
        FingerprintManager fingerprintManager;
        KeyguardManager keyguardManager;
        // Variable used for storing the key in the Android Keystore container
        private static String KEY_NAME = DeviceUtils.getManufacturer() + DeviceUtils.getModel();
        private Fingerprint(Context context){
            // Initializing both Android Keyguard Manager and Fingerprint Manager
           keyguardManager  = (KeyguardManager) context.getSystemService(KEYGUARD_SERVICE);
           fingerprintManager = (FingerprintManager) context.getSystemService(FINGERPRINT_SERVICE);
        }
        public static Fingerprint newInstancia(Context context){
            return new Fingerprint(context);
        }

        @RequiresPermission(allOf = {Manifest.permission.USE_FINGERPRINT})
        public void startAuth(FingerprintManager.AuthenticationCallback callback){
            if (cipherInit()){
                FingerprintManager.CryptoObject cryptoObject = new
                        FingerprintManager.CryptoObject(cipher);

                CancellationSignal cancellationSignal = new CancellationSignal();

                this.fingerprintManager.authenticate(cryptoObject,cancellationSignal
                        ,0 ,callback ,null );
            }
        }
        /**
         * verifica si el dispositivo soporta fingerprint
         * @return true si soporta fingerprint, de lo contrario false
         */
        @RequiresPermission(Manifest.permission.USE_FINGERPRINT)
        public  boolean isHardwareDetected(){
            return this.fingerprintManager.isHardwareDetected();
        }

        /**
         * verifica si el dispositivo tiene al menos una huella registrada
         * @return true si tiene al menos una huella, de lo contrario false
         */
        @RequiresPermission(Manifest.permission.USE_FINGERPRINT)
        public boolean hasEnrolledFingerprints(){
            return this.fingerprintManager.isHardwareDetected();
        }

        /**
         * verifica si tiene la pantalla de seguridad activida
         * @return true si tiene la pantalla de seguridad activada, de lo contrario false
         */
        public boolean isKeyguardSecure(){
            return this.keyguardManager.isKeyguardSecure();
        }


        protected void generateKey() {
            try {
                keyStore = KeyStore.getInstance("AndroidKeyStore");
            } catch (Exception e) {
                e.printStackTrace();
            }


            KeyGenerator keyGenerator;
            try {
                keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore");
            } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
                throw new RuntimeException("Failed to get KeyGenerator instance", e);
            }


            try {
                keyStore.load(null);
                keyGenerator.init(new
                        KeyGenParameterSpec.Builder(KEY_NAME,
                        KeyProperties.PURPOSE_ENCRYPT |
                                KeyProperties.PURPOSE_DECRYPT)
                        .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
                        .setUserAuthenticationRequired(true)
                        .setEncryptionPaddings(
                                KeyProperties.ENCRYPTION_PADDING_PKCS7)
                        .build());
                keyGenerator.generateKey();
            } catch (NoSuchAlgorithmException |
                    InvalidAlgorithmParameterException
                    | CertificateException | IOException e) {
                throw new RuntimeException(e);
            }
        }


        public boolean cipherInit() {
            try {
                cipher = Cipher.getInstance(KeyProperties.KEY_ALGORITHM_AES + "/" + KeyProperties.BLOCK_MODE_CBC + "/" + KeyProperties.ENCRYPTION_PADDING_PKCS7);
            } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
                throw new RuntimeException("Failed to get Cipher", e);
            }


            try {
                keyStore.load(null);
                SecretKey key = (SecretKey) keyStore.getKey(KEY_NAME,
                        null);
                cipher.init(Cipher.ENCRYPT_MODE, key);
                return true;
            } catch (KeyPermanentlyInvalidatedException e) {
                return false;
            } catch (KeyStoreException | CertificateException | UnrecoverableKeyException
                    | IOException | NoSuchAlgorithmException | InvalidKeyException e) {
                throw new RuntimeException("Failed to init Cipher", e);
            }
        }
    }

    }

