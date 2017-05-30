/*
 * This file is part of bisq.
 *
 * bisq is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * bisq is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with bisq. If not, see <http://www.gnu.org/licenses/>.
 */

package io.bisq.core.payment;

import io.bisq.common.locale.FiatCurrency;
import io.bisq.core.payment.payload.ChaseQuickPayAccountPayload;
import io.bisq.core.payment.payload.PaymentAccountPayload;
import io.bisq.core.payment.payload.PaymentMethod;

public final class ChaseQuickPayAccount extends PaymentAccount {
    public ChaseQuickPayAccount() {
        super(PaymentMethod.CHASE_QUICK_PAY);
        setSingleTradeCurrency(new FiatCurrency("USD"));
    }

    @Override
    protected PaymentAccountPayload getPayload() {
        return new ChaseQuickPayAccountPayload(paymentMethod.getId(), paymentMethod.getMaxTradePeriod());
    }

    public void setEmail(String email) {
        ((ChaseQuickPayAccountPayload) paymentAccountPayload).setEmail(email);
    }

    public String getEmail() {
        return ((ChaseQuickPayAccountPayload) paymentAccountPayload).getEmail();
    }

    public void setHolderName(String holderName) {
        ((ChaseQuickPayAccountPayload) paymentAccountPayload).setHolderName(holderName);
    }

    public String getHolderName() {
        return ((ChaseQuickPayAccountPayload) paymentAccountPayload).getHolderName();
    }
}
