package br.senac.spring.authentication.account;


import com.querydsl.core.types.Predicate;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserAccountService {

    @Autowired
    private UserAccountRepository repository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public UserAccount saveUserAccount(UserAccount userAccount) {
        UserAccount build = UserAccount
                .builder()
                .fullName(userAccount.getFullName())
                .userName(userAccount.getUserName())
                .password(this.bCryptPasswordEncoder.encode(userAccount.getPassword())).build();
        return this.repository.save(build);
    }

    public List<UserAccount> getListUserAccount(Predicate predicate) {
        return this.repository.findAll(predicate);
    }

    public UserAccount getUserAccount(Integer id) {
        return this.repository.findById(id).get();
    }

    public void deleteUserAccount(Integer id) {
        this.repository.deleteById(id);
    }
}
