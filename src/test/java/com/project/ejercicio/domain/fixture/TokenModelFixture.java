package com.project.ejercicio.domain.fixture;

import com.project.ejercicio.data.entity.UserEntity;
import com.project.ejercicio.data.model.TokenModel;

public class TokenModelFixture {
    public static TokenModel tokenModelMock() {
        TokenModel token = new TokenModel();
        token.setJwt("Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJKV1QiLCJzdWIiOiJBZHJpw6FuIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTY4MTIyOTE5OCwiZXhwIjoxNjgxMjI5Nzk4fQ.nIAcNHEY7nZa2sNpteeC9tD9IHL8I2EaRqN3xg5Hzt6BjIER7dwi28Ykn4xBCqAKyV9T5-4CBYBPT_ssaZvNtA");
        return token;
    }
}
