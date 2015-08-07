package com.novopay.sohammusicplayer;

import android.test.suitebuilder.annotation.SmallTest;

import com.novopay.sohammusicplayer.utils.ValidationUtils;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


@SmallTest
public class ValidationTests {

    @Before
    public void setup() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertThat(ValidationUtils.isValidEmail("name@email.com")).isFalse();
    }

    @Test
    public void emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertThat(ValidationUtils.isValidEmail("name@email.co.uk")).isTrue();
    }

    @Test
    public void emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertThat(ValidationUtils.isValidEmail("name@email")).isFalse();
    }

    @Test
    public void emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertThat(ValidationUtils.isValidEmail("name@email..com")).isFalse();
    }

    @Test
    public void emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        assertThat(ValidationUtils.isValidEmail("@email.com")).isFalse();
    }

    @Test
    public void emailValidator_EmptyString_ReturnsFalse() {
        assertThat(ValidationUtils.isValidEmail("")).isFalse();
    }

    @Test
    public void emailValidator_NullEmail_ReturnsFalse() {
        assertThat(ValidationUtils.isValidEmail(null)).isFalse();
    }
}