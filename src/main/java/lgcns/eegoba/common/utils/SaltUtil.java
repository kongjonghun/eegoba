package lgcns.eegoba.common.utils;

import org.springframework.stereotype.Service;
import org.mindrot.jbcrypt.BCrypt;

@Service
public class SaltUtil {

    /**
     * 비밀번호를 Bcrypt 암호화한다.
     * @param salt
     * @param password
     * @return
     */
    public String encodePassword(String salt, String password){
        return BCrypt.hashpw(password, salt);
    }

    /**
     * Salt 값을 얻는다.
     * @return
     */
    public String getSalt(){
        return BCrypt.gensalt();
    }

    /**
     * 암호화된 비밀번호와 입력된 비밀번호를 비교
     * @param password
     * @param hashPassword
     * @return
     */
    public boolean checkPassword(String password, String hashPassword){
        return BCrypt.checkpw(password, hashPassword);
    }
}
