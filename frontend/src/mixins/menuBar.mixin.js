const menuBar = {
    data() {
        return {
            items: [
                {
                    label: "File",
                    icon: "pi pi-fw pi-file",
                    items: [
                        {
                            label: "New",
                            icon: "pi pi-fw pi-plus",
                            items: [
                                {
                                    label: "Bookmark",
                                    icon: "pi pi-fw pi-bookmark",
                                },
                                {
                                    label: "Video",
                                    icon: "pi pi-fw pi-video",
                                },
                            ],
                        },
                        {
                            label: "Delete",
                            icon: "pi pi-fw pi-trash",
                        },
                        {
                            separator: true,
                        },
                        {
                            label: "Export",
                            icon: "pi pi-fw pi-external-link",
                        },
                    ],
                },
                {
                    label: "Sign Out",
                    icon: "pi pi-fw pi-sign-out",
                    command: (event) => this.$store.dispatch("auth/logout")
                },
            ],
        };
    },
}
export default menuBar;