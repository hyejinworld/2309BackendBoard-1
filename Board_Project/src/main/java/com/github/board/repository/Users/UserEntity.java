package com.github.board.repository.Users;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert      //엔티티 변화가 있는 컬럼에 대해서만 SQL 실행
@Where(clause = "is_deleted= false")   // sql(where문)에서 is_deleted false인 행들만 조회
@Table(name = "user")
public class UserEntity {
    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name",nullable = true,length = 20)  //테이블 수정 후 다 false로 바꾸기
    private String user_name;
    @Column(name = "email",nullable = true,length = 255)
    private String email;
    @Column(name = "password",nullable = true,length = 255)
    private String password;
    @Column(name = "create_time",nullable = true)
    private LocalDateTime create_time;
    @Column(name = "update_time",nullable = true)
    private LocalDateTime update_time;
    @Column(name = "id_deleted")
    private boolean is_deleted = false;


}