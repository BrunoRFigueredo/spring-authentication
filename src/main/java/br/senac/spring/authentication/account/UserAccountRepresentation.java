package br.senac.spring.authentication.account;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

import java.util.List;
import java.util.stream.Collectors;

public interface UserAccountRepresentation {

    @Getter
    @Setter
    @Builder
    class ListaUserAccount {
        private Integer id;
        private String fullName;
        private String userName;

        public static ListaUserAccount from(UserAccount userAccount) {
            return ListaUserAccount.builder()
                    .id(userAccount.getId())
                    .fullName(userAccount.getFullName())
                    .userName(userAccount.getUserName())
                    .build();
        }

        public static List<ListaUserAccount> from(List<UserAccount> userAccountList) {
            return userAccountList.stream().map(ListaUserAccount::from).collect(Collectors.toList());
        }
    }


}
