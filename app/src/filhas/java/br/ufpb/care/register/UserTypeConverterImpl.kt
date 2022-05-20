package br.ufpb.care.register

import br.ufpb.care.core.users.model.UserType
import br.ufpb.care.register.model.UserKind
import br.ufpb.care.register.model.UserKindsImpl
import java.lang.Exception

object UserTypeConverterImpl : UserTypeConverter {
    override fun fromUserKind(kind: UserKind): UserType =
        when (kind) {
            UserKindsImpl.patient -> UserType("Paciente")
            UserKindsImpl.caregiver -> UserType("Cuidador")
            UserKindsImpl.supportGroup -> UserType("Grupo de Apoio")
            else -> throw Exception("Unknown UserKind")
        }
}