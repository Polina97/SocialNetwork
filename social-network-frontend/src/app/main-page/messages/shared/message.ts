export class Message {
  personalMessageId: number;
  message: string;
  readed: boolean;
  date: string;
  editEndDate?: string;
  owner: string;
  ownerIdOnly: string;
}
