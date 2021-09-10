package br.senac.spring.authentication.account;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserAccountRepository extends CrudRepository<UserAccount, Integer> ,
        QuerydslPredicateExecutor<UserAccount>, QuerydslBinderCustomizer<QUserAccount> {

    List<UserAccount> findAll(Predicate predicate);

    @Override
    default public void customize(QuerydslBindings bindings, QUserAccount root) {

        bindings.bind(root.fullName).first((StringPath path, String value) -> path.containsIgnoreCase(value));

    }
}
