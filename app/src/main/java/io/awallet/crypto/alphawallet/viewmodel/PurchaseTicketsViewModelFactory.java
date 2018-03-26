package io.awallet.crypto.alphawallet.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import io.awallet.crypto.alphawallet.interact.CreateTransactionInteract;
import io.awallet.crypto.alphawallet.interact.FindDefaultNetworkInteract;
import io.awallet.crypto.alphawallet.interact.FindDefaultWalletInteract;
import io.awallet.crypto.alphawallet.service.MarketQueueService;

/**
 * Created by James on 23/02/2018.
 */

public class PurchaseTicketsViewModelFactory implements ViewModelProvider.Factory {

    private FindDefaultNetworkInteract findDefaultNetworkInteract;
    private FindDefaultWalletInteract findDefaultWalletInteract;
    private CreateTransactionInteract createTransactionInteract;
    private MarketQueueService marketQueueService;

    public PurchaseTicketsViewModelFactory(FindDefaultNetworkInteract findDefaultNetworkInteract,
                                           FindDefaultWalletInteract findDefaultWalletInteract,
                                           CreateTransactionInteract createTransactionInteract,
                                           MarketQueueService marketQueueService) {
        this.findDefaultNetworkInteract = findDefaultNetworkInteract;
        this.findDefaultWalletInteract = findDefaultWalletInteract;
        this.createTransactionInteract = createTransactionInteract;
        this.marketQueueService = marketQueueService;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new PurchaseTicketsViewModel(findDefaultNetworkInteract, findDefaultWalletInteract, createTransactionInteract, marketQueueService);
    }
}
