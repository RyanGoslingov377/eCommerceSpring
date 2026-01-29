package com.jtspringproject.JtSpringProject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHash {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "admin123";  // в†ђ РёР·РјРµРЅРё РЅР° Р»СЋР±РѕР№ РїР°СЂРѕР»СЊ, РєРѕС‚РѕСЂС‹Р№ С…РѕС‡РµС€СЊ РёСЃРїРѕР»СЊР·РѕРІР°С‚СЊ
        String hashed = encoder.encode(rawPassword);
        System.out.println("Р“РѕС‚РѕРІС‹Р№ BCrypt-С…СЌС€ РґР»СЏ '" + rawPassword + "':");
        System.out.println(hashed);
    }
}

