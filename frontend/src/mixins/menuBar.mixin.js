import router from "../router";

const menuBar = {
    data() {
        return {
            items: [
                {
                    label: "Rooms",
                    icon: "pi pi-fw pi-file",
                    items: [
                        {
                            label: "New",
                            icon: "pi pi-fw pi-plus",
                            command:(event)=>this
                        },
                        {
                            label: "View",
                            icon: "pi pi-fw pi-table",
                        },
                    ],
                },
                {
                    label: "Sign Out",
                    icon: "pi pi-fw pi-sign-out",
                    command: (event) => this.$store.dispatch("auth/logout") && this.$forceUpdate()
                },
            ],
        };
    },
}
export default menuBar;