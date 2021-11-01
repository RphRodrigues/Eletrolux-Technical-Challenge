package br.com.rstudio.myapplication.featureA

import io.mockk.MockK
import io.mockk.MockKDsl
import io.mockk.MockKVerificationScope
import io.mockk.Ordering

fun verifyNever(
    ordering: Ordering = Ordering.UNORDERED,
    inverse: Boolean = false,
    atLeast: Int = 1,
    atMost: Int = Int.MAX_VALUE,
    timeout: Long = 0,
    verifyBlock: MockKVerificationScope.() -> Unit
) = MockK.useImpl {
    MockKDsl.internalVerify(ordering, inverse, atLeast, atMost, exactly = 0, timeout, verifyBlock)
}

fun coVerifyNever(
    ordering: Ordering = Ordering.UNORDERED,
    inverse: Boolean = false,
    atLeast: Int = 1,
    atMost: Int = Int.MAX_VALUE,
    timeout: Long = 0,
    verifyBlock: suspend MockKVerificationScope.() -> Unit
) = MockK.useImpl {

    MockKDsl.internalCoVerify(
        ordering,
        inverse,
        atLeast,
        atMost,
        exactly = 0,
        timeout,
        verifyBlock
    )
}
