
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderManager from "./components/listers/OrderCards"
import OrderDetail from "./components/listers/OrderDetail"

import OrderInfoView from "./components/OrderInfoView"
import OrderInfoViewDetail from "./components/OrderInfoViewDetail"
import OrderHistoryView from "./components/OrderHistoryView"
import OrderHistoryViewDetail from "./components/OrderHistoryViewDetail"
import PaymentManager from "./components/listers/PaymentCards"
import PaymentDetail from "./components/listers/PaymentDetail"

import OrderManagementManager from "./components/listers/OrderManagementCards"
import OrderManagementDetail from "./components/listers/OrderManagementDetail"

import OrderInfoView from "./components/OrderInfoView"
import OrderInfoViewDetail from "./components/OrderInfoViewDetail"
import NotificaitonManager from "./components/listers/NotificaitonCards"
import NotificaitonDetail from "./components/listers/NotificaitonDetail"

import DeliveryManager from "./components/listers/DeliveryCards"
import DeliveryDetail from "./components/listers/DeliveryDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders',
                name: 'OrderManager',
                component: OrderManager
            },
            {
                path: '/orders/:id',
                name: 'OrderDetail',
                component: OrderDetail
            },

            {
                path: '/orderInfos',
                name: 'OrderInfoView',
                component: OrderInfoView
            },
            {
                path: '/orderInfos/:id',
                name: 'OrderInfoViewDetail',
                component: OrderInfoViewDetail
            },
            {
                path: '/orderHistories',
                name: 'OrderHistoryView',
                component: OrderHistoryView
            },
            {
                path: '/orderHistories/:id',
                name: 'OrderHistoryViewDetail',
                component: OrderHistoryViewDetail
            },
            {
                path: '/payments',
                name: 'PaymentManager',
                component: PaymentManager
            },
            {
                path: '/payments/:id',
                name: 'PaymentDetail',
                component: PaymentDetail
            },

            {
                path: '/orderManagements',
                name: 'OrderManagementManager',
                component: OrderManagementManager
            },
            {
                path: '/orderManagements/:id',
                name: 'OrderManagementDetail',
                component: OrderManagementDetail
            },

            {
                path: '/orderInfos',
                name: 'OrderInfoView',
                component: OrderInfoView
            },
            {
                path: '/orderInfos/:id',
                name: 'OrderInfoViewDetail',
                component: OrderInfoViewDetail
            },
            {
                path: '/notificaitons',
                name: 'NotificaitonManager',
                component: NotificaitonManager
            },
            {
                path: '/notificaitons/:id',
                name: 'NotificaitonDetail',
                component: NotificaitonDetail
            },

            {
                path: '/deliveries',
                name: 'DeliveryManager',
                component: DeliveryManager
            },
            {
                path: '/deliveries/:id',
                name: 'DeliveryDetail',
                component: DeliveryDetail
            },



    ]
})
