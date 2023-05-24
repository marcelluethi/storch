/*
 * Copyright 2022 storch.dev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package torch

import org.bytedeco.pytorch.global.torch as torchNative

import internal.NativeConverters.*

package object special:
  /** Computes the logarithmic derivative of the gamma function on `input`. */
  def digamma[D <: RealNN](input: Tensor[D]): Tensor[FloatPromoted[D]] =
    Tensor(torchNative.digamma(input.native))

  /** Computes the error function of `input`. */
  def erf[D <: RealNN](input: Tensor[D]): Tensor[FloatPromoted[D]] =
    Tensor(torchNative.erf(input.native))

  /** Computes the complementary error function of `input`. */
  def erfc[D <: RealNN](input: Tensor[D]): Tensor[FloatPromoted[D]] =
    Tensor(torchNative.erfc(input.native))

  /** Computes the inverse error function of `input`. The inverse error function is defined in the
    * range (−1,1)
    */
  def erfinv[D <: RealNN](input: Tensor[D]): Tensor[FloatPromoted[D]] =
    Tensor(torchNative.erfinv(input.native))

  /** Computes the base two exponential function of `input`. */
  def exp2[D <: RealNN](input: Tensor[D]): Tensor[FloatPromoted[D]] =
    Tensor(torchNative.exp2(input.native))

  /** Computes the exponential of the elements minus 1 of `input`. */
  def expm1[D <: RealNN](input: Tensor[D]): Tensor[FloatPromoted[D]] =
    Tensor(torchNative.expm1(input.native))

  /** Computes the zeroth order modified Bessel function of the first kind for each element of
    * `input`.
    */
  def i0[D <: RealNN](input: Tensor[D]): Tensor[FloatPromoted[D]] =
    Tensor(torchNative.i0(input.native))

  /** Computes the regularized lower incomplete gamma function */
  // NOTE it is named `gammainc` in pytorch torch.special
  def igamma[D <: DType, D2 <: DType](
      input: Tensor[D],
      other: Tensor[D2]
  ): Tensor[FloatPromoted[Promoted[D, D2]]] =
    Tensor(torchNative.igamma(input.native, other.native))

  /** Computes the regularized upper incomplete gamma function */
  // NOTE it is named `gamaincc` in pytorch torch.special
  def igammac[D <: DType, D2 <: DType](
      input: Tensor[D],
      other: Tensor[D2]
  ): Tensor[FloatPromoted[Promoted[D, D2]]] =
    Tensor(torchNative.igammac(input.native, other.native))

  /** Returns a new tensor with the logit of the elements of `input`. `input` is clamped to [eps, 1
    * \- eps] when eps is not None. When eps is None and input < 0 or input > 1, the function will
    * yields NaN.
    */
  def logit[D <: DType](input: Tensor[D], eps: Option[Double]): Tensor[FloatPromoted[D]] =
    Tensor(torchNative.logit(input.native, toOptional(eps)))

  /** Computes the multivariate log-gamma function with dimension p element-wise */
  // NOTE it is named `multigammaln` in pytorch torch.special
  def mvlgamma[D <: DType](input: Tensor[D], p: Int): Tensor[FloatPromoted[D]] =
    Tensor(torchNative.mvlgamma(input.native, p))

  /** Computes the nth derivative of the digamma function on `input`. n≥0 is called the order of the
    * polygamma function.
    */
  def polygamma[D <: DType](n: Int, input: Tensor[D]): Tensor[FloatPromoted[D]] =
    Tensor(torchNative.polygamma(n, input.native))

  /** Computes the expit (also known as the logistic sigmoid function) of the elements of `input`.
    */
  // NOTE it is named `expit` in pytorch torch.special
  def sigmoid[D <: DType](input: Tensor[D]): Tensor[FloatPromoted[D]] =
    Tensor(torchNative.sigmoid(input.native))

  /** Returns a new tensor with the normalized sinc of the elements of `input`. */
  def sinc[D <: RealNN](input: Tensor[D]): Tensor[FloatPromoted[D]] =
    Tensor(torchNative.sinc(input.native))
