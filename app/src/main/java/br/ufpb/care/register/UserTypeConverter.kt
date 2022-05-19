package br.ufpb.care.register

import br.ufpb.care.core.users.model.UserType
import br.ufpb.care.register.model.UserKind

interface UserTypeConverter {
    fun fromUserKind(kind: UserKind): UserType
}