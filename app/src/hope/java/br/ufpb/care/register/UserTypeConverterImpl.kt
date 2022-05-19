package br.ufpb.care.register

import br.ufpb.care.core.users.model.UserType
import br.ufpb.care.register.model.UserKind
import br.ufpb.care.register.model.UserKindsImpl
import java.lang.Exception

object UserTypeConverterImpl : UserTypeConverter {
    override fun fromUserKind(kind: UserKind): UserType =
        when (kind) {
            UserKindsImpl.codependent -> UserType("Codependente")
            UserKindsImpl.dependent -> UserType("Dependente")
            UserKindsImpl.exDependent -> UserType("Ex-Dependente")
            else -> throw Exception("Unknown UserKind")
        }
}