package com.example.figma2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.figma2.entity.User;
import com.example.figma2.enums.Role;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String username);

//    boolean existsByEmail(String email);
//
//    User findByActivationCode(Integer code);
//
//    List<User> findByRoleEquals(Role role);
//
//    boolean existsByUsername(String username);
//
//    Optional<User> findByUsername(String username);
//
//    boolean existsByPhoneNumber(String phoneNumber);
//
//    boolean existsByPhoneNumberAndIdNot(String phoneNumber, Integer id);
//
//    boolean existsByEmailAndIdNot(String email, Integer id);
//
//    boolean existsByUsernameAndIdNot(String username, Integer id);

//
//    @Query(value = """
//    SELECT u.*
//    FROM users u
//    WHERE role NOT IN ('ROLE_USER')
//      AND u.deleted = false
//      AND u.enabled = true
//    """,
//            countQuery = """
//    SELECT COUNT(*)
//    FROM users u
//    WHERE role NOT IN ('ROLE_USER')
//      AND u.deleted = false
//      AND u.enabled = true
//    """,
//            nativeQuery = true)
//    Page<User> getAll(Pageable pageRequest);
//
//
//    @Query(
//            value = """
//        SELECT
//            COUNT(DISTINCT u.id) AS total_users,
//            COUNT(DISTINCT CASE WHEN r.name = 'seller' THEN u.id END) AS total_sellers
//        FROM users u
//        LEFT JOIN user_roles ur ON u.id = ur.user_id
//        LEFT JOIN roles r ON ur.role_id = r.id
//        """,
//            nativeQuery = true
//    )
//    Object getUserAndSellerCount();
//
//
//    Integer countByRole(Role role);
//    @Query(value = """
//        SELECT
//            u.id AS userId,
//            u.first_name AS firstName,
//            u.last_name AS lastName,
//            COUNT(DISTINCT o.id) AS totalOrders,
//            COALESCE(SUM(oi.quantity), 0) AS totalProductsBought
//        FROM users u
//        LEFT JOIN orders o ON o.user_id = u.id
//        LEFT JOIN order_item oi ON oi.order_id = o.id
//        GROUP BY u.id, u.first_name,u.last_name
//        ORDER BY u.id
//        """, nativeQuery = true)
//    List<Map<String, Object>> getUserStatistics();


}
