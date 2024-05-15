package com.example.socialmediaapp.di

import com.example.socialmediaapp.domain.remote.repository.registration.RegistrationRepository
import com.example.socialmediaapp.domain.remote.usecase.registration.UserRegistrationUseCase
import com.example.socialmediaapp.domain.remote.usecase.validation.user.EmailValidationUseCase
import com.example.socialmediaapp.domain.remote.usecase.validation.user.PasswordRepeatValidationUseCase
import com.example.socialmediaapp.domain.remote.usecase.validation.user.PasswordValidationUseCase
import com.example.socialmediaapp.domain.remote.usecase.validation.user.UsernameValidationUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

//    @Provides
//    @Singleton
//    fun provideUserRegistrationUseCase(
//        registrationRepository: RegistrationRepository
//    ): UserRegistrationUseCase {
//        return UserRegistrationUseCase(registrationRepository = registrationRepository)
//    }

    @Singleton
    @Provides
    fun provideEmailValidatorUseCase(): EmailValidationUseCase {
        return EmailValidationUseCase()
    }

    @Singleton
    @Provides
    fun providePasswordValidatorUseCase(): PasswordValidationUseCase {
        return PasswordValidationUseCase()
    }

    @Singleton
    @Provides
    fun providePasswordReenterValidatorUseCase(): PasswordRepeatValidationUseCase {
        return PasswordRepeatValidationUseCase()
    }

    @Singleton
    @Provides
    fun provideUsernameValidatorUseCase(): UsernameValidationUseCase {
        return UsernameValidationUseCase()
    }

}