package vn.spring.nam.notification.configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Configuration
public class FcmConfig {
    @Value("${firebase.properties}")
    private String FIREBASE_PROPERTIES;

    private String dragonBall;
//    @Bean
//    public GoogleCredentials googleCredentials() {
//        try {
//            return GoogleCredentials.fromStream
//                    (new ClassPathResource(FIREBASE_PROPERTIES).getInputStream());
//        } catch (IOException e) {
//            throw new RuntimeException("Can not find firebase properties file", e);
//        }
//    }
//    @Bean
//    public FirebaseApp firebaseApp(GoogleCredentials credentials) {
//        FirebaseOptions firebaseOptions = FirebaseOptions.builder()
//                .setCredentials(credentials)
//                .build();
//        return FirebaseApp.initializeApp(firebaseOptions);
//    }
//    @Bean
//    public FirebaseMessaging firebaseMessaging(FirebaseApp firebaseApp) {
//        return FirebaseMessaging.getInstance(firebaseApp);
//    }

    public String namND345345(String abc){
        System.out.println("ABC" + abc);
        return abc;
    }

    @Bean
    public FirebaseMessaging firebaseApp() throws IOException {





        /// 9qop7w4etyi1uwyterfgdjutyasfdyuikafsdasd

        InputStream serviceAccount  = getClass().getClassLoader().getResourceAsStream("firebase-prop.json" );

        if (serviceAccount == null) {
            throw new IllegalArgumentException("Không tìm thấy tệp tài khoản dịch vụ trong tài nguyên");
        }

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp app = FirebaseApp.initializeApp(options);

        return FirebaseMessaging.getInstance(app);
    }

    /// Nam nd1p280371o29i3tyiasgdoiasgdiu
    /*
     * nam test git NAIQSGDLIASGDKLJHAGSDLGASD
     * PQWIOUETGOAISUDGDASIOYUGASDX
     * ASDFIPUGASD UGASDXCOLHFGASDLHJKGASDHJKLGASDKLUGHJASDGHJKLasd ghjklasd ghjkleAS HJKLGASDGUASDDGJKL
     *
     *
     *
     *
     *
     *
     *
     * Q0WOP978E4TYQWOUIYTEDJKQSYRFDKAJYSZFGDKJYASFGDKJYAFSDKUYASFDO76QW
     *
     *
     *
     *
     * QPISTGEKAJSGDKAJHSGD
     */
    public String namND(String abc) {
        System.out.println("ABC" + abc);
        return abc;
    }

    public List<String> namND2(String abc) {
        System.out.println("ABC" + abc);
        return List.of(abc);
    }
    public String namND19287361239(Integer abc){
        System.out.println("ABC" + abc);

        return abc.toString();
    }


    public void namND3(String abc) {
        System.out.println("DEF" + abc);
    }
}
